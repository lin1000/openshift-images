source ./setenv.sh
source ./docker-build-local.sh
docker_push $(basename $(pwd)) 1.0 172.30.1.1:5000 lin1000