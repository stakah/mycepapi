rem remove image
docker image rm mycepapi

rem rebuild project
cmd /C build-mycepapi.cmd

rem build
docker buildx build --tag mycepapi:latest .
