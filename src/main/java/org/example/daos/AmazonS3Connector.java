package org.example.daos;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public final class AmazonS3Connector {

    private static final String REGION = "eu-west-1";
    private static AmazonS3 amazonS3Client;
    private static final String ENDPOINT_URL = System.getenv("ENDPOINT_URL");

    private AmazonS3Connector() {}

    public static AmazonS3 getAmazonS3Client() {

        if (amazonS3Client != null) {
            return amazonS3Client;
        }

        if (ENDPOINT_URL != null) {
            amazonS3Client = getAwsClientWithLocalEnvVariables();
        } else {
            amazonS3Client = getAwsClientWithProfileCredentials();
        }

        return amazonS3Client;
    }

    private static AmazonS3 getAwsClientWithLocalEnvVariables() {
        String accessKeyId = System.getenv("AWS_SECRET_KEY_ID");
        String secretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY");

        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);

        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_URL, REGION))
                .withClientConfiguration(new ClientConfiguration().withProtocol(Protocol.HTTP))
                .build();
    }

    private static AmazonS3 getAwsClientWithProfileCredentials() {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(REGION)
                .build();
    }
}
