/**
 * Created by Administrator on 2018/6/10.
 */
function checkEmpty(str) {

    if (str==null||str==undefined||str==""){
        return false;
    }

    return true;
}

function checkLength(str,lenMin,lenMax) {

    if (str.length<lenMin||str.length>lenMax){
        return false;
    }

    return true;
}