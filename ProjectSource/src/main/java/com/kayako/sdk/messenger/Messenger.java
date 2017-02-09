package com.kayako.sdk.messenger;

import com.kayako.sdk.ParserFactory;
import com.kayako.sdk.RequesterFactory;
import com.kayako.sdk.auth.FingerprintAuth;
import com.kayako.sdk.base.callback.ListCallback;
import com.kayako.sdk.base.manager.ListManager;
import com.kayako.sdk.base.requester.RequestCallback;
import com.kayako.sdk.error.KayakoException;
import com.kayako.sdk.messenger.conversation.Conversation;
import com.kayako.sdk.utils.FingerprintUtils;

import java.util.List;

/**
 * @author Neil Mathew (neil.mathew@kayako.com)
 * @date 08/02/17
 */
public class Messenger {

    private String mHelpDeskUrl;
    private FingerprintAuth mFingerprintAuth;

    /**
     * Create a Messenger instance for a new user - generating a new Fingerprint Id
     *
     * @param helpDeskUrl
     */
    public Messenger(String helpDeskUrl) {
        mHelpDeskUrl = helpDeskUrl;
        mFingerprintAuth = generateNewFingerprintId();
    }

    /**
     * Create a Messenger instance for an existing user - using the existing Fingerprint Id
     *
     * @param helpDeskUrl
     * @param fingerprintAuth
     */
    public Messenger(String helpDeskUrl, FingerprintAuth fingerprintAuth) {
        mHelpDeskUrl = helpDeskUrl;
        mFingerprintAuth = fingerprintAuth;
    }

    /**
     * This is useful when you'd like to save the fingerprint auth for multiple requests using the same authentications
     *
     * @return
     */
    public FingerprintAuth getFingerprintAuth() {
        return mFingerprintAuth;
    }

    /**
     * Reset the fingerprint authentication of the current Authentication
     *
     * @param mFingerprintAuth
     */
    public void setFingerprintAuth(FingerprintAuth mFingerprintAuth) {
        this.mFingerprintAuth = mFingerprintAuth;
    }

    // TODO: GET List Conversations
    // TODO: GET List Messages
    // TODO: POST Conversation
    // TODO: POST Message

    public List<Conversation> getConversationList() throws KayakoException {
        return new ListManager<Conversation>(RequesterFactory.getConversationListRequester(mHelpDeskUrl, mFingerprintAuth), ParserFactory.getConversationListParser()).getList();
    }

    public void getConversationList(ListCallback<Conversation> callback) {
        new ListManager<Conversation>(RequesterFactory.getConversationListRequester(mHelpDeskUrl, mFingerprintAuth), ParserFactory.getConversationListParser()).getList(callback);
    }

    private FingerprintAuth generateNewFingerprintId() {
        String fingerprintId = FingerprintUtils.generateUUIDv4();
        return new FingerprintAuth(fingerprintId);
    }

}