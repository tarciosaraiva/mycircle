#!/usr/bin/env bash

# more bash-friendly output for jq
JQ="jq --raw-output --exit-status"

configure_aws_cli(){
    aws --version
    aws configure set default.region ap-southeast-2
    aws configure set default.output json
}

push_ecr_image(){
    eval $(aws ecr get-login --region ap-southeast-2)
    docker push $AWS_ACCOUNT_ID.dkr.ecr.ap-southeast-2.amazonaws.com/mycircle-repository:$CIRCLE_SHA1
}

configure_aws_cli
push_ecr_image
