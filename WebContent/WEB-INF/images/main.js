function killErrors() {return true;}
window.onerror = killErrors;

function $(id){return document.getElementById(id);}

var lastCtrl = new Object();
function DoLocation(ctrl)
{
	if(ctrl != lastCtrl){
		lastCtrl.className = "left_link";
	}
	ctrl.className = "left_link_over";
	lastCtrl = ctrl;
}

function pucker_show(name,no,hiddenclassname,showclassname) {
    //name:����ǰ׺
    //no:��ǰ���������������
    //showclassname:չ��״̬��ʽ��
    //hiddenclassname:�۵�״̬��ʽ��
    for (var i=1 ;i<7 ;i++ )
    {
        $(name+i).className=hiddenclassname;
    }
    $(name+no).className=showclassname;
}

function selectTag(showContent,selfObj){
	// ������ǩ
	var tag = $("sdcms_sub_title").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "unsub";
	}
	selfObj.parentNode.className = "sub";
	// ��������
	for(i=0; j=$("tagContent"+i); i++){
		j.style.display = "none";
	}
	$(showContent).style.display = "block";
}
function unselectall()
{
    if(document.add.chkAll.checked){document.add.chkAll.checked = document.add.chkAll.checked&0; }
}

function CheckAll(form)
{
  for (var i=0;i<form.elements.length;i++)
    {
    var e = form.elements[i];
    if (e.Name != "chkAll")
       e.checked = form.chkAll.checked;
    }
}

function CopyUrl(target)
{ 
	target.value=get_c.value; 
	target.select();   
	js=get_c.createTextRange();   
	js.execCommand("Copy"); 
	alert("���Ƴɹ�!"); 
} 

function Display(ID){
	if ($(ID).style.display == "none"){
		$(ID).style.display="block";
	}else{
	    $(ID).style.display="none";
	}
}