$handle = openf('models/model.bin');
$model = readObject($handle);
closef($handle);