package org.example.daos;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AmazonS3Connector {

    private static final String REGION = "eu-west-1";
    private static AmazonS3 amazonS3Client;

    private AmazonS3Connector() {
    }

    public static AmazonS3 getAmazonS3Client() {

        if (amazonS3Client != null) {
            return amazonS3Client;
        }

        amazonS3Client = AmazonS3ClientBuilder
                .standard()
                .withRegion(REGION)
                .build();

        return amazonS3Client;
    }
}
