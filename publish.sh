#!/bin/bash

set -e
./gradlew clean slack-api:publish
