# rhalice-api

## Modules
- `core`: common stuffs, utils
- `sea` - it's below the ground, I mean it's a sea. It's a domain-lib which include `entity`, `dto` and `repo`
- `user` - userbase module. We may keep `UserEntity` and `Organization` entity in this module. That will make sure it will never refer to other entity in other modules
- `slack` - everything about Slack: bot, slack users
- `auth`
- `timeoff`
- `app`: top level application, everything gather together
- `slack-api`: will be removed
## Authentication
The user can authenticate with Slack, email/password or whatever mean.


## Exception
- `ApiException` is a better way to throw application error to client. It includes a list of application error codes that may be thrown to clients
- `HttpRequestException` is used to throw http error to service client (such as Cloud Task, App Engine, etc.)
- `MonExceptionController` translates exceptions into http error for controller
