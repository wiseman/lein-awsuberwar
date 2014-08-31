# lein-awsuberwar

A Leiningen plugin that can build an uberwar containing a
`.ebextensions` directory.

[lein-ring](https://github.com/weavejester/lein-ring) can't create an
uberwar suitable for AWS Elastic Beanstalk because it is
[hardcoded to not include paths in the WAR if the path name begins with a `.`](https://github.com/weavejester/lein-ring/issues/55),
which includes `.ebextensions`.

[lein-beanstalk](https://github.com/weavejester/lein-beanstalk) uses
lein-ring's uberwar, so it suffers from the same issue.

Mark Butler wrote a
[small patch](https://github.com/snowplow/snowplow/blob/master/2-collectors/clojure-collector/tasks/leiningen/aws.clj)
around lein-ring's uberwar command, and I've packaged it into a
standalone, easy-to-use lein plugin: lein-awsuberwar.

You can use the `:awsuberwar` profile in your `project.clj` to specify
options to use when creating an awsuberwar.


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
