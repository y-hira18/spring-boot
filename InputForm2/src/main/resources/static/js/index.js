/**
 *
 */
$(function() {
	// ボタンクリックで入力値を表示する
	$('#button').click(function() {

		$.ajax({
			type : 'get',
			url : '/getInputMessage',
			data : {
				inputMessage : $('#inputMessage').val()
			},
			dataType : 'json'
		}).then(
				function(data) {
					$('#outputMessage').val(data.inputMessage);
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});

	// セレクトボックスで選択した値を表示する
	$('#selectItem').change(function() {

		$.ajax({
			type : 'get',
			url : '/getSelectItem',
			data : {
				selectItem : $('#selectItem').val()
			},
			dataType : 'json'
		}).then(
				function(data) {
					$('#selectedItem').val(data.selectItem);
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});
});
