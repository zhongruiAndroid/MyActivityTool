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

ActTools.get(this).startForResult(intent,yourActivity.class,new ResultCallback(){
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
ActTools.startActivity(intent,this,yourActivity.class);
```

  
  | 最新版本号 | [ ![Download](https://api.bintray.com/packages/zhongrui/mylibrary/ActivityTools/images/download.svg) ](https://bintray.com/zhongrui/mylibrary/ActivityTools/_latestVersion) |  
|--------|----|  



```gradle  
compile 'com.github:ActivityTools:版本号看上面'
```
<br/>  

 Thanks https://juejin.im/post/5a4611786fb9a0451a76b565
