#!/bin/bash

jjtree parser.jjt
javacc parser.jj
javac *.java

