package com.sd.storage.api;

import com.dframe.lib.model.DataContainer;
import com.sd.storage.model.BarCodeModel;
import com.sd.storage.model.BarCodeInptListtModel;
import com.sd.storage.model.BarCodeSplitMianModel;
import com.sd.storage.model.BarCodeSplitSonModel;
import com.sd.storage.model.CodeGoodsModel;
import com.sd.storage.model.CodeGoodsSubmitModel;
import com.sd.storage.model.DepartmentModel;
import com.sd.storage.model.PanDianListModel;
import com.sd.storage.model.PandianDataListModel;
import com.sd.storage.model.UserModel;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by MrZhou on 2016/9/26.
 */
public interface ApiService {


    /*@GET("/app/customerApp/bankCard/{d}")
    Observable<DataContainer<ArrayList<DepartmentModel>>> getDeptItem(@Path("d") String controller,
                                                                      @QueryMap Map<String, String> params);*/

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<DepartmentModel>>> getDeptItem(@Path("d") String controller,
                                                                      @QueryMap Map<String, String> params);



  /*  @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> getDeptItem(@Path("d") String controller,
                                                                      @QueryMap Map<String, String> params);*/

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<UserModel>> CheckLogin(@Path("d") String controller,
                                                    @QueryMap Map<String, String> params);


    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<BarCodeInptListtModel>>> GetRfScmBoxList(@Path("d") String controller,
                                                                                @QueryMap Map<String, String> params);


    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> BoxChexkRef(@Path("d") String controller,
                                                  @QueryMap Map<String, String> params);

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<BarCodeModel>>> GetRfLotWmsBarCodeInptList(@Path("d") String controller,
                                                                                  @QueryMap Map<String, String> params);

   //
    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<BarCodeSplitMianModel>>> GetLotWmsBarCodeSplList(@Path("d") String controller,
                                                                                        @QueryMap Map<String, String> params);

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> SubmitLotWmsBarCodeData(@Path("d") String controller,
                                                              @QueryMap Map<String, String> params);


    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<BarCodeSplitSonModel>>> GetLotWmsBarCodeSubSplList(@Path("d") String controller,
                                                                                          @QueryMap Map<String, String> params);


    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> SubmitSubBarCodeSpl(@Path("d") String controller,
                                                          @QueryMap Map<String, String> params);



    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> ResetSubBarCodeSpl(@Path("d") String controller,
                                                          @QueryMap Map<String, String> params);

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> RemoveSubBarCodeSpl(@Path("d") String controller,
                                                         @QueryMap Map<String, String> params);

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<PanDianListModel>>> GetRfLotWmsBarCodeChkList(@Path("d") String controller,
                                                                                     @QueryMap Map<String, String> params);

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> SubmitWmsChkData(@Path("d") String controller,
                                                          @QueryMap Map<String, String> params);


    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<PandianDataListModel>>> GetRfLotWmsChkList(@Path("d") String controller,
                                                                                  @QueryMap Map<String, String> params);


    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<ArrayList<CodeGoodsModel>>> GetRfWmsAppBillList(@Path("d") String controller,
                                                                             @QueryMap Map<String, String> params);

    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<CodeGoodsSubmitModel>> SubmitWmsAppBillData(@Path("d") String controller,
                                                                         @QueryMap Map<String, String> params);


    @GET("/api/AppService.asmx/{d}")
    Observable<DataContainer<Object>> SubmitPurPosData(@Path("d") String controller,
                                                       @QueryMap Map<String, String> params);


}
