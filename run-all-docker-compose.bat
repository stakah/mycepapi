rem rebuild mycepapi image
cmd /C build-docker-image.cmd

rem run
docker compose -f docker-compose-all.yml up