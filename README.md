# lein-awsuberwar

A Leiningen plugin that can build an uberwar containing a
`.ebextensions` directory.

## Usage

Put `[lein-awsuberwar "0.1.0"]` into the `:plugins` vector of your
project.clj.

Then create an uberwar:

```
$ lein awsuberwar
```

## License

Copyright © 2014 John Wiseman

Distributed under the Eclipse Public License either version 1.0.
