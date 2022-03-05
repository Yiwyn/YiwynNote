## <font color='red'>索引执行计划</font>



- #### 执行计划

  - ##### 分析查询性能（Analyze Query Performance）通常使用执行计划（解释计划、Explain Plan）来查看查询的情况，查询消耗的时间、是否基于索引等。

  - ##### 通常情况下，观察索引是否生效，需要使用执行计划

    ```mysql
    db.collection.find(query,options).explain(options)
    ```

    - ##### 例

      ```mysql
      db.mycollection.find({title:"test"}).explain()  //这里title已经建立索引
      
       >>
      // 输出结果
       {
          "explainVersion" : "1",
          "queryPlanner" : {
              "namespace" : "testdb.mycollection",
              "indexFilterSet" : false,
              "parsedQuery" : {
                  "title" : {
                      "$eq" : "test"
                  }
              },
              "queryHash" : "6E0D6672",
              "planCacheKey" : "1953B8BB",
              "maxIndexedOrSolutionsReached" : false,
              "maxIndexedAndSolutionsReached" : false,
              "maxScansToExplodeReached" : false,
              "winningPlan" : {
                  "stage" : "FETCH",				//FETCH表示使用了索引 COLLSCAN全盘索引没有使用索引
                  "inputStage" : {
                      "stage" : "IXSCAN",
                      "keyPattern" : {
                          "title" : 1
                      },
                      "indexName" : "title_1",
                      "isMultiKey" : false,
                      "multiKeyPaths" : {
                          "title" : [ ]
                      },
                      "isUnique" : false,
                      "isSparse" : false,
                      "isPartial" : false,
                      "indexVersion" : 2,
                      "direction" : "forward",
                      "indexBounds" : {
                          "title" : [
                              "[\"飞平议期律议\", \"飞平议期律议\"]"
                          ]
                      }
                  }
              },
              "rejectedPlans" : [ ]
          },
          "command" : {
              "find" : "mycollection",
              "filter" : {
                  "title" : "飞平议期律议"
              },
              "$db" : "testdb"
          },
          "serverInfo" : {
              "host" : "fb3afffcc6ba",
              "port" : 27017,
              "version" : "5.0.6",
              "gitVersion" : "212a8dbb47f07427dae194a9c75baec1d81d9259"
          },
          "serverParameters" : {
              "internalQueryFacetBufferSizeBytes" : 104857600,
              "internalQueryFacetMaxOutputDocSizeBytes" : 104857600,
              "internalLookupStageIntermediateDocumentMaxSizeBytes" : 104857600,
              "internalDocumentSourceGroupMaxMemoryBytes" : 104857600,
              "internalQueryMaxBlockingSortMemoryUsageBytes" : 104857600,
              "internalQueryProhibitBlockingMergeOnMongoS" : 0,
              "internalQueryMaxAddToSetBytes" : 104857600,
              "internalDocumentSourceSetWindowFieldsMaxMemoryBytes" : 104857600
          },
          "ok" : 1
      }
       
      
      
      ```

      