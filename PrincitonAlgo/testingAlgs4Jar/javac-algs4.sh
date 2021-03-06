#!/bin/bash

# *************************************************
# javac-algs4
# Hayk Martirosyan
# -------------------
# Wrapper for javac that includes algs4.jar.
# *************************************************

# This must match the install directory
INSTALL=../

# Sets the path to the classpath libraries
jars=(.:${INSTALL}/algs4.jar)

javac -cp "$jars" -g -encoding UTF-8 "$@"