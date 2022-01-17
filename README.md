[revolt]: https://revolt.chat
[jda]: https://github.com/DV8FromTheWorld/JDA

<!-- Badges -->
[serverBadge]: https://shields.revolt.gay/badge/Join_Server-101823?style=for-the-badge&logo=revolt
[licenseBadge]: https://shields.revolt.gay/badge/License:_MIT*-101823?style=for-the-badge&logo=data:image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCIgd2lkdGg9IjI0IiBoZWlnaHQ9IjI0IiBmaWxsPSIjRkY0NjU0Ij48cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0xMi43NSAyLjc1YS43NS43NSAwIDAwLTEuNSAwVjQuNUg5LjI3NmExLjc1IDEuNzUgMCAwMC0uOTg1LjMwM0w2LjU5NiA1Ljk1N0EuMjUuMjUgMCAwMTYuNDU1IDZIMi4zNTNhLjc1Ljc1IDAgMTAwIDEuNUgzLjkzTC41NjMgMTUuMThhLjc2Mi43NjIgMCAwMC4yMS44OGMuMDguMDY0LjE2MS4xMjUuMzA5LjIyMS4xODYuMTIxLjQ1Mi4yNzguNzkyLjQzMy42OC4zMTEgMS42NjIuNjIgMi44NzYuNjJhNi45MTkgNi45MTkgMCAwMDIuODc2LS42MmMuMzQtLjE1NS42MDYtLjMxMi43OTItLjQzMy4xNS0uMDk3LjIzLS4xNTguMzEtLjIyM2EuNzUuNzUgMCAwMC4yMDktLjg3OEw1LjU2OSA3LjVoLjg4NmMuMzUxIDAgLjY5NC0uMTA2Ljk4NC0uMzAzbDEuNjk2LTEuMTU0QS4yNS4yNSAwIDAxOS4yNzUgNmgxLjk3NXYxNC41SDYuNzYzYS43NS43NSAwIDAwMCAxLjVoMTAuNDc0YS43NS43NSAwIDAwMC0xLjVIMTIuNzVWNmgxLjk3NGMuMDUgMCAuMS4wMTUuMTQuMDQzbDEuNjk3IDEuMTU0Yy4yOS4xOTcuNjMzLjMwMy45ODQuMzAzaC44ODZsLTMuMzY4IDcuNjhhLjc1Ljc1IDAgMDAuMjMuODk2Yy4wMTIuMDA5IDAgMCAuMDAyIDBhMy4xNTQgMy4xNTQgMCAwMC4zMS4yMDZjLjE4NS4xMTIuNDUuMjU2Ljc5LjRhNy4zNDMgNy4zNDMgMCAwMDIuODU1LjU2OCA3LjM0MyA3LjM0MyAwIDAwMi44NTYtLjU2OWMuMzM4LS4xNDMuNjA0LS4yODcuNzktLjM5OWEzLjUgMy41IDAgMDAuMzEtLjIwNi43NS43NSAwIDAwLjIzLS44OTZMMjAuMDcgNy41aDEuNTc4YS43NS43NSAwIDAwMC0xLjVoLTQuMTAyYS4yNS4yNSAwIDAxLS4xNC0uMDQzbC0xLjY5Ny0xLjE1NGExLjc1IDEuNzUgMCAwMC0uOTg0LS4zMDNIMTIuNzVWMi43NXpNMi4xOTMgMTUuMTk4YTUuNDE4IDUuNDE4IDAgMDAyLjU1Ny42MzUgNS40MTggNS40MTggMCAwMDIuNTU3LS42MzVMNC43NSA5LjM2OGwtMi41NTcgNS44M3ptMTQuNTEtLjAyNGMuMDgyLjA0LjE3NC4wODMuMjc1LjEyNi41My4yMjMgMS4zMDUuNDUgMi4yNzIuNDVhNS44NDYgNS44NDYgMCAwMDIuNTQ3LS41NzZMMTkuMjUgOS4zNjdsLTIuNTQ3IDUuODA3eiI+PC9wYXRoPjwvc3ZnPg==

[server]: https://app.revolt.chat/invite/5m0Gnyk3
[license]: https://github.com/Andre601/Revolt4J/blob/master/LICENSE

<img alt="revolt4j_logo" align="right" src="https://raw.githubusercontent.com/Andre601/Revolt4J/master/.assets/logo/revolt4j.png" height="200" width="200">

# Revolt4J

[![serverBadge]][server] [![licenseBadge]](#about-licesnes)

Revolt4J is a Java Wrapper for [revolt.chat][revolt] an open source Text and VOIP Service.

It was heavily influenced by [JDA] and tries to support the Revolt API as good as it can while also being efficient.

## Current Status
**Revolt4J is NOT in a ready state as of now! (Last updated: 17.01.2022)**

The Wrapper still lacks a lot of necessary features to make it functional on at least a basic level.  
If you're up to the challenge can you try to PR some changes to the wrapper. Any help is welcome as this is my first time working on such a project in such a scale.

## Current plans/Goals

- Fully working Websocket system to communicate properly with the Revolt API.
- Support all available Events Revolt currently has.
- Caching-System to keep entities such as users and reduce API calls.
- Rest action system similar to JDAs allowing for execution of methods without worrying to encounter rate limits (unintentionally).
- Some other stuff that I can't remember but that are important somehow...

## About Licenses
Revolt4J is using parts of Code from [JDA].  
Because of this do not all parts of this project fall under the [default MIT License][license]. All parts that do use code from JDA fall under their [Apache License 2.0][jda-license] and are not considered an official part of Revolt4J.

**At no point are the maintainers of Revolt4J claiming ownership of the code taken from JDA. Code was taken with permission of their maintainers. The maintainers of JDA do not support nor endorse Revolt4J or the Revolt project itself!**

## Links

- Revolt Server: https://app.revolt.chat/invite/5m0Gnyk3
