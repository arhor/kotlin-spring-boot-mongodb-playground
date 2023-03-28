Creating `.env.local` file inside service directory is necessary for the local deployment.

Content of the file for the current service should be the following (with `<placeholders>` replaced):

```properties
SPRING_DATA_MONGODB_HOST     = <mongodb-host>
SPRING_DATA_MONGODB_PORT     = <mongodb-port>
SPRING_DATA_MONGODB_DATABASE = <mongodb-name>
```
