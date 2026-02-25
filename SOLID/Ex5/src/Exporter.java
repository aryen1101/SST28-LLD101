public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public final ExportResult export(ExportRequest req){
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest cannot be null");
        }
        String title = (req.title == null) ? "" : req.title;
        String body = (req.body == null) ? "" : req.body;
        
        ExportRequest cleanReq = new ExportRequest(title, body);

        return doExport(cleanReq);

    }

    public abstract ExportResult doExport(ExportRequest req);
}
