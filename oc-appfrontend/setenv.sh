# $1 is openapi.merge=[true or false]
function gradlew_bootJar(){
	./gradlew bootJar -Popenapi.merge=$1
}

function mvn_package(){
	mvn clean package
}

# $1 is openapi.merge=[true or false]
function gradlew_compile_and_merge(){
	./gradlew clean compileJava -Popenapi.merge=$1
}

# $1 is service name
# $2 is version
function docker_build(){
	docker build . -t $1:$2 \
	--build-arg SRC_JAR_FILE=target/service-$2.jar \
	--build-arg SERVICE_JAR_FILE_NAME=service.jar \
	--build-arg APP_NAME=$1 \
	--build-arg APP_VERSION=$2
}

# $1 is service name
# $2 is version
# $3 is target_registery_url
# $4 is target_registery namespace
function docker_tag(){
	docker tag $1:$2 $3/$4/$1:$2
}

# $1 is service name
# $2 is version
# $3 is target_registery_url
# $4 is target_registery namespace
function docker_push(){
	docker push $3/$4/$1:$2
}


# $1 is service name
# $2 is version
# $3 is node port
# $4 is container expose port
function docker_run_local(){
	docker_rm $1-local
	docker run --net mynet --name $1-local -d -p $3:$4 $1:$2	
}

# $1 is container_name
function docker_rm(){
	docker rm -f $1
}



