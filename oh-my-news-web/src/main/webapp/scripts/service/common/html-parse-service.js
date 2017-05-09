  /**
 * Created by shj on 2017/4/19.
 */
app.service('htmlParseService',['constant',function (constant) {
    var htmlParseService = {}
    var index = 0;
    htmlParseService.parseHtml = function (html) {
        var div = document.createElement('div');
        div.innerHTML = html;
        var res = {
            img: [],
            video: [],
            text: ''
        };
        parseNode(div,res);
        return res;
    };

    var parseNode = function(node,res) {
        if(node==undefined||node==null){
            return;
        }
        alert(node.tagName+" length: "+node.childNodes.length);
        if(node.tagName!=undefined&&node.tagName.toLowerCase()==constant.getImgTagName().toLowerCase()){
            var src = node.getAttribute('src');
            if(src!=undefined&&src!=null&&src!=''){
                res.img.push(src);
            };
        }else if(node.tagName!=undefined&&node.tagName.toLowerCase()==constant.getVideoTagName().toLowerCase()){
            var src = node.getAttribute('src');
            if(src!=undefined&&src!=null&&src!=''){
                res.video.push(src);
            };
        }else if(node.childNodes==undefined||node.childNodes==null||node.childNodes.length==1){
            if(node.innerHTML!=undefined&&node.innerHTML!=null)
                res.text+=node.innerHTML;
        };
        if(node.childNodes!=undefined&&node.childNodes!=null&&node.childNodes.length>1){
            for(var i=0;i<node.childNodes.length;i++){
                parseNode(node.childNodes.item(i),res);
            }
        }
    };


    return htmlParseService;
}])