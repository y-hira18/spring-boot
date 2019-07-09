/**
 *
 */
$(function() {
	// ボタンクリックで入力値を表示する
	$('#show-input-message-btn').click(function() {

		$.ajax({
			type : 'get',
			url : '/getInputMessage',
			data : {
				inputMessage : $('#input-message').val()
			},
			dataType : 'json'
		}).then(
				function(data) {
					$('#output-message').val(data.inputMessage);
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});

	// セレクトボックスで選択した値を表示する
	$('#select-item').change(function() {

		$.ajax({
			type : 'get',
			url : '/getSelectItem',
			data : {
				selectItem : $('#select-item').val()
			},
			dataType : 'json'
		}).then(
				function(data) {
					$('#selected-item').val(data.selectItem);
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});

	// 入力値をテーブルに表示する
	$('#show-input-value-btn').click(function() {

		// fragment(HTML)を取得する
		$.ajax({
			type : 'get',
			url : '/getInputValue',
			data : {
				inputMessage : $('#input-message').val(),
				selectItem : $('#select-item').val()
			},
			dataType : 'html'
		}).then(
				function(data) {
					$('#input-value').html(data);
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});

	// 左のセレクトボックスで選択した分類に紐づく食品を右のセレクトボックスに表示する
	$('#food-classification').change(function() {

		$.ajax({
			type : 'get',
			url : '/getClassifiedFoodList',
			data : {
				classificationId : $('#food-classification').val()
			},
			dataType : 'json'
		}).then(
				function(data) {

					document.getElementById("classified-food").options.length = 0;

					$.each(data, function(index, value) {
						let option = document.createElement("option");
						option.text = value.foodName;
						option.value = value.foodId;
						document.getElementById("classified-food").appendChild(option);
					});
				},
				function(XMLHttpRequest, textStatus, errorThrown) {
					alert('error:' + XMLHttpRequest + '/' + textStatus
							+ '/' + errorThrown);
				});
	});
});
