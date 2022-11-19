# RSBOX
An Open-Source Old School RuneScape Private Server and SDK

## Setup
**Requirements**
- Jetbrains IntelliJ IDE
- AdoptJDK 11

**Important:** Make sure you have JDK 11 installed on your system and the "adoptjdk/bin/" folder
is in your *PATH* env variable on your system.

- Clone the repo to you system.
```shell
git clone https://github.com/rsbox/rsbox
```

- Open the project in intellij by going to ``File > New > Project from existing sources``.
- Expand the ``Gradle`` tab on the right-hand menu and run the task. ``rsbox > Tasks > build > Build``.
- Run the Gradle task ``rsbox > Tasks > rsbox > 'setup server'``.

- Start the server with gradle task: ``rsbox > Tasks > rsbox > 'run server'``.
- Start the development client with gradle task: ``rsbox > Tasks > rsbox > 'run client'``.

To log in, type any username and password. This will create the account and if this is the first account
login, it will be granted ``Administrator`` role for the server.

## Project Development
This project is in no way ready for production use and is still being developed. Below
are some project goals. This list will be updated constantly as we acchive more parts of
the project.

Additionally, Every task here can be found as a project in the repo. There you can find more information on
the status of each.

- [ ] Cache Library
- [ ] Network Module
- [ ] Engine Module
- [ ] Content API
- [ ] Content scripts