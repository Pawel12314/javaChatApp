#Currently app is not finished and will be refactored. I post it because of time shortage, this is only to show that i can code something in java spring.
# Application contains beans xml configurations for each component. All of Redis, H2 db and JPA and mongo db are instantiated using only beans xml configurations files.

#Currently app provides functionality like registering new user, using spring redis, in future it will be made with rest. User is stored in h2 database using jpa. App contains sample code of mongodb using models which inherits one from other and type casting using visitor pattern.

# This is going to be an chat app with features like chat using spring redis, there will be two types of chats - private and group chat. Accounts in jpa will have aliases for dashboard purposes. Default alias is identity of user and other aliases ar used for purposes like managing fanpage or organization. dashboard, which uses these aliases will be filtered by likes, follows, and friend list. 

