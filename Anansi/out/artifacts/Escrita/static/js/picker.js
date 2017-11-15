var headerHtml = $("#material-header-holder .ui-datepicker-material-header");

var changeMaterialHeader = function(header, date) {
    var year   = date.format('YYYY');
    var month  = date.format('MMM');
    var dayNum = date.format('D');
    var isoDay = date.isoWeekday();

    var weekday = new Array(7);
    weekday[1] = "Segunda";
    weekday[2] = "Terça";
    weekday[3] = "Quarta";
    weekday[4] = "Quinta";
    weekday[5] = "Sexta";
    weekday[6] = "Sábado";
    weekday[7]=  "Domingo";

    $('.ui-datepicker-material-day', header).text(weekday[isoDay]);
    $('.ui-datepicker-material-year', header).text(year);
    $('.ui-datepicker-material-month', header).text(month);
    $('.ui-datepicker-material-day-num', header).text(dayNum);
};

$.datepicker._selectDateOverload = $.datepicker._selectDate;
$.datepicker._selectDate = function(id, dateStr) {
    var target = $(id);
    var inst = this._getInst(target[0]);
    inst.inline = true;
    $.datepicker._selectDateOverload(id, dateStr);
    inst.inline = false;
    this._updateDatepicker(inst);
    headerHtml.remove();
    $(".ui-datepicker").prepend(headerHtml);
};

//alert($.datepicker.formatDate( "yy, MM d, DD", new Date( 2007, 7 - 1, 14 )));
//alert($.datepicker.formatDate( "yy-mm-d", new Date( 2007, 7 - 1, 14 )));

$("input[data-type='date']").on("focus", function() {
    $(".ui-datepicker").prepend(headerHtml);
});

/*
 *  //constrainInput: true,
 *  //showOn: 'button',
 *  //buttonText: 'Select Date',
 * */
$("input[data-type='date']").datepicker({
    dateFormat: 'dd/mm/yy',
    constrainInput: true,
    showButtonPanel: true,
    closeText: 'OK',
    onSelect: function(date, inst) {
        //console.log(date);
        //console.log(moment(date, 'MM/DD/YYYY').format('YYYY-MM-DD'));
        //changeMaterialHeader(headerHtml, moment(date, 'MM/DD/YYYY'));
        changeMaterialHeader(headerHtml, moment(date, 'DD/MM/YYYY'));
        $("#birthDateID").empty();
    },
});

changeMaterialHeader(headerHtml, moment());
//$('input').datepicker('show');
//$('input').datepicker( "setDate", "10/12/2012" );

//Fixed Today Button
var old_goToToday = $.datepicker._gotoToday
$.datepicker._gotoToday = function(id) {
    old_goToToday.call(this,id)
    this._selectDate(id)
}

