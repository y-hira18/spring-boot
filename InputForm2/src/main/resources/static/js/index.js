/**
 *
 */
$(function() {
	// ボタンクリックで入力値を表示する
	$('#inputMessageSubmit').click(function() {

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

	// 入力値をテーブルに表示する
	$('#submit').click(function() {

		// fragment(HTML)を取得する
		$.ajax({
			type : 'get',
			url : '/getInputValue',
			data : {
				inputMessage : $('#inputMessage').val(),
				selectItem : $('#selectItem').val()
			},
			dataType : 'html'
		}).then(
				function(data) {
					$('#result').html(data);
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});

	// 左のセレクトボックスで選択した分類に紐づく食品を右のセレクトボックスに表示する
	$('#classification').change(function() {

		$.ajax({
			type : 'get',
			url : '/getFoodListLinkToClassification',
			data : {
				classificationId : $('#classification').val()
			},
			dataType : 'json'
		}).then(
				function(data) {

					document.getElementById("food").options.length = 0;

					$.each(data, function(index, value) {
						let option = document.createElement("option");
						option.text = value.foodName;
						option.value = value.foodId;
						document.getElementById("food").appendChild(option);
					});
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});
});
