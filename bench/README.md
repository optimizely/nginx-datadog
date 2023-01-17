Performance Benchmarking
========================
Run this:
```console
$ bin/run
```

In another shell, you can run this:
```console
$ bin/monitor-stats
```

Then wait a long time.

Then run this:
```console
$ bin/histogram --xdivisor 1000 --cutoff 500000 --bins 200 output/{baseline,control,test}
```

and this:
```console
$ bin/summary --significance output/{baseline,control,test}
```

Configuration
-------------
The environment variables that affect a test build/run are defined, along with
their default values, in [defaults.conf.sh][1].

To override the default values, assign to the same variables in a file called
`conf.sh`. [bin/run][2] will first source `defaults.conf.sh`, and then source
`conf.sh` if it exists.

Output
------
Test run output goes to [./output/][3]. Each of the three client services write
their round-trip latency numbers to a file.  Resource consumption statistics are
written to another file. When the test is finished, service logs (standard
output and error of each service) are written together to another file.

Time units are nanoseconds, and data units are bytes.

Dependencies
------------
- docker
- docker compose plugin (e.g. `apt install docker-compose-plugin`)
- python3
- gnuplot

[1]: ./defaults.conf.sh
[2]: ./bin/run
[3]: ./output
