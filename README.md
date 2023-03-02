# SearchTemplate Demo

To make use of Elastic Search Template in Java backend API<br />

## Description

*Since the current(5.0.2)version of Spring data Elastic Search haven't support search template features(https://github.com/spring-projects/spring-data-elasticsearch/issues/1891)<br />
*This project used upcoming major version 5.1.0-M2 instead.<br />
*I created a demo template with three params(name, page, size) to query.<br />
```
{
  "script": {
    "lang": "mustache",
    "source": {
      "query": {
        "match": {
          "name": "{{name}}"
        }
      },
      "from":"{{from}}",
      "size":"{{size}}"
    },
  "params": {
    "name": "Supervisor,Providence Health & Services",
    "from":"1",
    "size":"1"
    }
  }
}
```
## API:
localhost:8080/search/{name}<br />
sample:<br />
localhost:8080/search?page=1&size=1

