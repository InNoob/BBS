window.onload = function() {
    UE.getEditor('newTopic-ueditor', {
        toolbars: [
            [
                'source', '|', 'undo', 'redo', '|', 'bold', 'italic', 'underline', 'strikethrough', '|', 'forecolor', '|', 'removeformat', '|',
                'cleardoc', 'paragraph', '|', 'fontfamily', 'fontsize', 'link', 'unlink', '|', 'emotion', 'simpleupload', 'attachment',
                '|', 'drafts', 'formula'
            ]
        ],
        initialFrameWidth: 1110,
        initialFrameHeight: 400,
        autoHeightEnabled: false,
        elementPathEnabled: false, //是否启用元素路径，默认是显示
        emotionLocalization: true,
    });
}


function getContent(){
    document.getElementById("topiccontent").value = UE.getEditor('newTopic-ueditor').getContent();
    document.getElementById("form1").submit();
    return false;
}