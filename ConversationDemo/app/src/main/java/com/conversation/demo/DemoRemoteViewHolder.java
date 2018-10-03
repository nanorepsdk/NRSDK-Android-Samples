package com.conversation.demo;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.nanorep.convesationui.viewholder.BubbleRemoteViewHolder;
import com.nanorep.convesationui.viewholder.RemoteResourcesProvider;
import com.nanorep.convesationui.viewholder.controllers.ChatElementController;
import com.nanorep.nanoengine.chatelement.ChatElement;
import com.nanorep.nanoengine.chatelement.RemoteOptionsChatElement;
import com.nanorep.nanoengine.model.AgentType;


/**
 * Created by Aviran Abady on 8/25/17.
 */
public class DemoRemoteViewHolder extends BubbleRemoteViewHolder {
    private final ImageView avatarImageView;

    public DemoRemoteViewHolder(View view, ChatElementController controller) {
        super(view, new RemoteResources(), controller);

        this.avatarImageView = itemView.findViewById(R.id.demo_agent_avatar);
    }


    @Override
    public void bind(@NonNull ChatElement element, int position, int totalCount) {
        super.bind(element, position, totalCount);

        if (!(element instanceof RemoteOptionsChatElement) || avatarImageView == null) {
            return;
        }

        RemoteOptionsChatElement remoteChatElement = (RemoteOptionsChatElement) element;
        avatarImageView.setImageResource(remoteChatElement.getAgentType().equals(AgentType.Live) ?
                R.drawable.mr_chatbot :
                R.drawable.bold_360);
    }

    static class RemoteResources extends RemoteResourcesProvider {
        @Override
        public int getPersistentOptionTextViewId() {
            return R.id.my_persistent_text;
        }

        @Override
        public int getPersistentOptionLayout() {
            return R.layout.persistent_option;
        }
    }
}
