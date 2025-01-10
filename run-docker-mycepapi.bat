rem run
docker run -it --rm --name mycepapi --network mycepapi_back-tier -p 8080:8080 mycepapi:latest