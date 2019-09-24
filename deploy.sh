#!/bin/bash

set -e

appengine_id="hr2020"
app_yaml=""
version_prefix="j01"
export alice_deployment_promote="true"
githash=`git log --format="%H" -n 1`
hash=${githash:0:7}

#if [[  $1 == 'prod' ]] ; then
#    appengine_id="standupbot2017"
#    app_yaml="alice/deployment/app_prod.yaml"
#    githash=`git log --format="%H" -n 1`
#    hash=${githash:0:7}
#elif [[  $1 == 'dev' ]] ; then
#    appengine_id="alicedev9"
#    app_yaml="alice/deployment/app_dev.yaml"
#    hash="dev$2"
#else
#    echo "$0 [prod|dev] [flex]: deploy backend, flex is optional"
#    echo "$0 [prod|dev] cron: update cron tasks"
#    exit
#fi

#update code
git pull

#if grep -q create "alice/src/main/resources/application-gae_prod.yml"; then
#  echo "Invalid application-gae_prod.yml. Should be ddl-auto: update"
#  exit
#fi

echo "Deploy to env=${1}, appengineId=${appengine_id} yaml=${app_yaml}..."

export alice_deployment_version="${version_prefix}-${hash}"
export alice_deployment_project="${appengine_id}"
echo ${alice_deployment_project} ${alice_deployment_version}

gcloud config set project ${appengine_id}

./gradlew clean
./gradlew app:appengineDeploy
