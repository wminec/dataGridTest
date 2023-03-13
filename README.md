# What is This Repository?
this is test java code using inifispan through the hotrod protocol.

# Prerequisites
1. setup infinispan server

# how to Use
1. change "infinispan.client.hotrod.server_list" Value in hotord.properties
2. Change the value of "rcm.getCache" in "App.java" to the cache name defined in infinispan.

Example
```bash
                ...
                <distributed-cache name="KHAN_SESSION" mode="SYNC" segments="50" owners="2" start="EAGER" remote-timeout="120000" l1-lifespan="0">
                    <state-transfer enabled="true"/>
                    <expiration interval="1000" />
                    <locking isolation="READ_COMMITTED" acquire-timeout="30000" concurrency-level="1000" striping="false"/>
                    <transaction mode="NONE"/>
                </distributed-cache>
                ...
```
3. Run Code!