#pragma once
#include "jmat.h"
#include "net.h"
#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <stdio.h>
#include <vector>


class Mobunet{
    private:
      int m_wenetstep = 20;
      int m_rgb =0;
        ncnn::Net unet;
        // 输入归一化: [0, 255] -> [0, 1] (ToTensor 风格)
        float mean_vals[3] = {0.0f, 0.0f, 0.0f};
        float norm_vals[3] = {1.0f / 255.0f, 1.0f / 255.0f, 1.0f / 255.0f};
        JMat*   mat_weights = nullptr;
        JMat*   mat_weightmin = nullptr;
        int initModel(const char* binfn,const char* paramfn,const char* mskfn);
    public:
        int domodel(JMat* pic,JMat* msk,JMat* feat,int rect = 160);
        int domodelold(JMat* pic,JMat* msk,JMat* feat);
        int preprocess(JMat* pic,JMat* feat);
        int process(JMat* pic,const int* boxs,JMat* feat);
        int fgprocess(JMat* pic,const int* boxs,JMat* feat,JMat* fg);
        int process2(JMat* pic,const int* boxs,JMat* feat);
        Mobunet(const char* modeldir,const char* modelid,int rgb = 0);
        Mobunet(const char* fnbin,const char* fnparam,const char* fnmsk,int wenetstep = 20,int rgb = 0);
        ~Mobunet();
};
