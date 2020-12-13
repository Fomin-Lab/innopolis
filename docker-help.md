### Создать образ
docker build --tag sfomin/javaee25 .

### Запустить контейнер
docker run -it --rm -p 8080:8080 --name=jee sfomin/javaee25