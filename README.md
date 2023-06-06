Sample code to for fetching blobs from Azure Blob Storage using CDN


1) Create a CDN profile

2) If it's first time with CDN profile, go to your current subcription--> Resource Providers--> Will see that Microsoft.Cdn is not registered. Hence register it. We can do it via portal or few commands. 


Reference  = https://learn.microsoft.com/en-us/azure/azure-resource-manager/troubleshooting/error-register-resource-provider?tabs=azure-cli

3) Signout and login again, I had to do that else was getting similar error that CDN is not registered.

4) Create a Storage Account and then create an container inside it and upload a sample file.

for me container is 'sample' and file is 'Goal'

5) Go to storage account and on left side to Azure CDN

You can create a new CDN profile here or use the existing one we created earlier.

6) Create a new CDN endpoint and after creation go to CDN profile and make sure it appears there

7) Go to SAS token creation option on the Storage and **give access to services, containers, blob and all necessary access.**

8) Create a sample Maven project in local and update the pom and main class as per this.

9) While creating BlobServiceClient in code try replacing the endpoint with CDN_ENDPOINT/STORAGE_ENDPOINT

10) With CDN_ENDPOINT value, the time will be less as it helps us to cache there and provide very fast response than using the STORAGE_ENDPOINT value directly. 

A lot of times with CDN_ENDPOINT value I faced an error(due to some race condition and couldn't figure out the solution, blob sdk was latest during I tried 12.22.2) , very few times only it would work, but with STORAGE_ENDPOINT it worked at all times.
Still noticed whenever the CDN_ENDPOINT case ran it was faster as I believe that is how it should work and it is made for that.


Issue - https://github.com/Azure/azure-sdk-for-java/issues/6181

