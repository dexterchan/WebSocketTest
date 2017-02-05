/**
 * http://usejsdoc.org/
 */

var table=null
$(document).ready(function() {
    //var table = $('#example').DataTable();
 
	$('#displaypanel').show()
	$('#displaypanel2').hide()
	table = $('#example').DataTable( {
        "paging":   false,
        "ordering": true,
        "info":     false,
        "processing": true,
        "serverSide": true,
        "ajax": "/listallperson2",
        "columns": [
            { "data": "name" },
            { "data": "position" },
            { "data": "office" },
            { "data": "extn" },
            { "data": "start_date" },
            { "data": "salary" }
        ],
        "columnDefs": [
            { className: "dt-right", "targets": [3,4,5] },
            { className: "dt-nowrap", "targets": [0,1] }
          ]
          
    } );
    
    $('#example tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
    } );
 
    $('#button').click( function () {
        alert( table.rows('.selected').data().length +' row(s) selected' );
    } );
} );

table.ajax.reload();