package org.example;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class App {
    private static final String CDN_ENDPOINT = "https://hello1.azureedge.net";
    private static final String STORAGE_ENDPOINT = "https://cdnexplore.blob.core.windows.net";

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .sasToken("sv******")
                .endpoint(CDN_ENDPOINT)
                .buildClient();

        BlobContainerClient destinationBlobClient = blobServiceClient.getBlobContainerClient("sample");
        System.out.println(destinationBlobClient.getBlobClient("Goal").downloadContent().toString());

        System.out.println(System.currentTimeMillis()-time);

    }
}

