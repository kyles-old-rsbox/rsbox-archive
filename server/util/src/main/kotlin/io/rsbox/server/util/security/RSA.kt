/*
 * Copyright (C) 2022 RSBox <Kyle Escobar>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.rsbox.server.util.security

import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.util.io.pem.PemObject
import org.bouncycastle.util.io.pem.PemReader
import org.bouncycastle.util.io.pem.PemWriter
import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException
import java.math.BigInteger
import java.nio.file.Files
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.Security
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.security.spec.PKCS8EncodedKeySpec

class RSA {

    lateinit var exponent: BigInteger private set
    lateinit var modulus: BigInteger private set

    fun load() {
        if(!PRIVATE_KEY_FILE.exists()) {
            throw FileNotFoundException("Failed to load the RSA private key file at: /data/rsa/private.pem.")
        }

        PemReader(Files.newBufferedReader(PRIVATE_KEY_FILE.toPath())).use {
            val pem = it.readPemObject()
            val keySpec = PKCS8EncodedKeySpec(pem.content)

            Security.addProvider(BouncyCastleProvider())

            val factory = KeyFactory.getInstance("RSA", "BC")
            val privateKey = factory.generatePrivate(keySpec) as RSAPrivateKey

            exponent = privateKey.privateExponent
            modulus = privateKey.modulus
        }
    }

    companion object {

        private const val KEY_SIZE = 1024

        private val PUBLIC_KEY_FILE = File("data/rsa/public.pem")
        private val PRIVATE_KEY_FILE = File("data/rsa/private.pem")
        private val PUBLIC_MODULUS_FILE = File("data/rsa/modulus.txt")
        private val CLIENT_PUBLIC_MODULUS_FILE = File("client/src/main/resources/modulus.txt")

        fun generateNewKeyPair() {
            Logger.info("Generating new RSA private/public key-pair...")

            PUBLIC_KEY_FILE.deleteRecursively()
            PRIVATE_KEY_FILE.deleteRecursively()
            PUBLIC_MODULUS_FILE.deleteRecursively()
            CLIENT_PUBLIC_MODULUS_FILE.deleteRecursively()

            Security.addProvider(BouncyCastleProvider())

            val generator = KeyPairGenerator.getInstance("RSA", "BC")
            generator.initialize(KEY_SIZE)

            val keyPair = generator.generateKeyPair()
            val publicKey = keyPair.public as RSAPublicKey
            val privateKey = keyPair.private as RSAPrivateKey

            Logger.info("Saving RSA encryption key files to: /data/rsa/.")

            PemWriter(Files.newBufferedWriter(PUBLIC_KEY_FILE.toPath())).use {
                it.writeObject(PemObject("RSA PUBLIC KEY", publicKey.encoded))
            }

            PemWriter(Files.newBufferedWriter(PRIVATE_KEY_FILE.toPath())).use {
                it.writeObject(PemObject("RSA PRIVATE KEY", privateKey.encoded))
            }

            Files.newBufferedWriter(PUBLIC_MODULUS_FILE.toPath()).use {
                it.write(publicKey.modulus.toString(16))
            }

            Logger.info("Setting up development client with generated RSA keys.")
            Files.newBufferedWriter(CLIENT_PUBLIC_MODULUS_FILE.toPath()).use {
                it.write(publicKey.modulus.toString(16))
            }

            Logger.info("Successfully generated and saved the new RSA private/public key-pair files.")
        }
    }
}