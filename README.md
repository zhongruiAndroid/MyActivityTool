# MyActivityTool
### startActivityForResult
```java
ActTools.get(this).startForResult(yourActivity.class,new ResultCallback(){
    @Override
    public void onActivityResult(int resultCode, Intent data) {
        if(resultCode==RESULT_OK){
        
        }
  }
});

ActTools.get(this).startForResult(yourActivity.class,intent,new ResultCallback(){
    @Override
    public void onActivityResult(int resultCode, Intent data) {
        if(resultCode==RESULT_OK){
        
        }
    }
});
```

### startActivity
```java
ActTools.startActivity(this,yourActivity.class);
ActTools.startActivity(this,yourActivity.class,intent);
```

  
  | 最新版本号 | [ ![Download](https://yapi.bintray.com/packages/zhongrui/mylibrary/ActivityTool/images/download.svg) ](https://bintray.com/zhongrui/mylibrary/ActivityTool/_latestVersion) |  
|--------|----|  



```gradle  
compile 'com.github:ActivityTools:版本审核中'
```
<br/>  

 Thanks https://juejin.im/post/5a4611786fb9a0451a76b565
