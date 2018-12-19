source ./setenv.sh

mvn_package
docker_build $(basename $(pwd)) 1.0
docker_tag $(basename $(pwd)) 1.0 172.30.1.1:5000 lin1000