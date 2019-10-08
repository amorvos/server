package cn.wildfirechat.sdk;

import cn.wildfirechat.common.APIPath;
import cn.wildfirechat.pojos.Conversation;
import cn.wildfirechat.pojos.InputGetUserInfo;
import cn.wildfirechat.pojos.InputOutputUserInfo;
import cn.wildfirechat.pojos.MessagePayload;
import cn.wildfirechat.pojos.SendMessageData;
import cn.wildfirechat.pojos.SendMessageResult;
import cn.wildfirechat.sdk.model.IMResult;
import cn.wildfirechat.sdk.utilities.RobotHttpUtils;

public class RobotService {
    public static IMResult<SendMessageResult> sendMessage(String sender, Conversation conversation, MessagePayload payload) throws Exception {
        String path = APIPath.Robot_Message_Send;
        SendMessageData messageData = new SendMessageData();
        messageData.setSender(sender);
        messageData.setConv(conversation);
        messageData.setPayload(payload);
        return RobotHttpUtils.httpJsonPost(path, messageData, SendMessageResult.class);
    }

    public static IMResult<InputOutputUserInfo> getUserInfo(String userId) throws Exception {
        String path = APIPath.Robot_User_Info;
        InputGetUserInfo getUserInfo = new InputGetUserInfo(userId, null, null);
        return RobotHttpUtils.httpJsonPost(path, getUserInfo, InputOutputUserInfo.class);
    }
}
