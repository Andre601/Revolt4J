[revolt]: https://revolt.chat
[jda]: https://github.com/DV8FromTheWorld/JDA

# Revolt4J
Revolt4J is a Java wrapper for the [Revolt App][revolt].

It was heavily influenced by [JDA] and tries to support the Revolt API as good as it can while also being efficient.

## NOTE
**This Java wrapper is NOT in a ready state!**

It still needs a lot of work and since I don't have *ANY* knowledge regarding Websockets and similar is this a hard thing to achieve.  
If you want to help, consider making Pull requests to the project to get it in a somewhat ready state.

### Current plans/Goals

- Fully implement websocket system
- Make a Caching mechanic to not always request information from the Revolt API.
- Implement a system similar to JDA's RestAction, allowing to delay future requests without ratelimit encounters.
- Some other stuff I can't think of right now...

## Credits
Inspired by (And probably with some code of) [JDA].

Credits and proper Licenses are set where needed.