When spring boot starts up, it creates all beans of singleton scope by default. 
For example if we have @Service, @RestController, @Component, @Repository etc, beans for these classes will be of singleton.

Singleton - One instance of bean will be created for complete application irrespective of requests. 
- So when a singleton Controller, Service beans are dependent on singleton Component bean (Component bean injected to Controller, Service bean), then one instance of component is created and same instance injected to Controller and Service beans. If there is a change happened to Component bean in Service, that change will be reflected in Controller also.
- For any HTTP request coming to controller same bean will be used.

Prototype - New instance will be created for each bean call.
- So when a singleton Controller, Service beans are dependent on prototype Component bean (Component bean injected to Controller, Service bean), then two instance of component are created and injected to Controller and Service beans each. If there is a change happened to Component bean in Service, that change will not be reflected in Controller.
- For any HTTP request coming to controller same bean will be used instead of creating new instance. Here Prototype is behaving as singleton because prototype bean is injected to singleton bean.
- To over come this we can use,
  - @Lookup on method fetching prototype instance. This will return the new instance of method return type.
  - ObjectFactory can be used to get new instance for every request as shown in this example.
  
Request - New instance will be created for each request.
- So when a singleton Controller, Service beans are dependent on request Component bean (Component bean injected to Controller, Service bean), then one instance of component is created and injected to Controller and Service beans. If there is a change happened to Component bean in Service, that change will be reflected in Controller also.
- For any HTTP request coming to controller new bean will be created and same instance will be used untill request completes.