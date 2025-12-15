package ai.guiji.duix;

public class DuixNcnn
{
    public native int alloc(int taskid,int mincalc,int width,int height);
    public native int free(int taskid);
    public native int initPcmex(int maxsize,int minoff,int minblock,int maxblock,int rgb);
    public native int initWenet(String fnwenet);
    public native int initMunet(String fnparam,String fnbin,String fnmask);
    public native int initMunetex(String fnparam,String fnbin,String fnmask, int kind);

    /**
     * 直接初始化模型（无需解密）
     * 用于加载标准的 NCNN .param 和 .bin 文件
     * 
     * @param fnparam NCNN param 文件路径 (如 model.param)
     * @param fnbin   NCNN bin 文件路径 (如 model.bin)  
     * @param fnmask  Alpha 权重文件路径 (如 weight_168u.bin)
     * @param fnwenet Wenet ONNX 模型路径
     * @param width   视频宽度
     * @param height  视频高度
     * @param kind    模型类型 (128 或 168)
     * @return 0 成功，其他失败
     */
    public native int initDirect(String fnparam, String fnbin, String fnmask, String fnwenet, 
                                 int width, int height, int kind);

    public native long newsession();
    public native int finsession(long sessid);
    public native int consession(long sessid);
    public native int allcnt(long sessid);
    public native int readycnt(long sessid);
    public native int pushpcm(long sessid,byte[] arrbuf,int size, int kind);

    public native int filerst(long sessid,String picfn,String mskfn,
        int[] arrbox,String fgpic,int index, byte[] arrimg,byte[] arrmsk,int imgsize);

    public native int bufrst(long sessid, int[] arrbox,int index, byte[] arrimg,int imgsize);

    public native int fileload(String picfn,String mskfn,int width,int height,
         byte[] arrpic,byte[] arrmsk,int imgsize);

    public native int startgpg(String picfn,String gpgfn);
    public native int stopgpg();
    public native int processmd5(int kind,String infn,String outfn);

    static {
             System.loadLibrary("gjduix");
    }
}
