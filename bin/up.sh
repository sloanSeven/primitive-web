#!/bin/bash


scp -i ~/primitive2.pem -r primitive-web/app ec2-user@ec2-34-203-130-126.compute-1.amazonaws.com:primitive-web/
scp -i ~/primitive2.pem -r primitive-web/bin ec2-user@ec2-34-203-130-126.compute-1.amazonaws.com:primitive-web/
scp -i ~/primitive2.pem -r primitive-web/conf ec2-user@ec2-34-203-130-126.compute-1.amazonaws.com:primitive-web/
scp -i ~/primitive2.pem -r primitive-web/ ec2-user@ec2-34-203-130-126.compute-1.amazonaws.com:primitive-web/