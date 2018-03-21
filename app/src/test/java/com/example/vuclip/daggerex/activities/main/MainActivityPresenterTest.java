package com.example.vuclip.daggerex.activities.main;

import com.example.vuclip.daggerex.network.NetworkManager;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Banty on 21/03/18.
 */
public class MainActivityPresenterTest {

    private MainActivityPresenter mainActivityPresenter;

    private NetworkManager mockNetworkManager;
    private MainActivityMVP.View mockView;

    @Before
    public void setUp() throws Exception {
        //mocking the network manager class, no need to provide actual network calls
        mockNetworkManager = mock(NetworkManager.class);

        //mocking the view for testing presenter
        mockView = mock(MainActivityMVP.View.class);

        mainActivityPresenter = new MainActivityPresenter(mockNetworkManager);
        mainActivityPresenter.setView(mockView);
    }

    @Test
    public void shouldUpdateViewAfterDataReceivedFromNetwork() throws Exception {
        List mockList = mock(List.class);
        mainActivityPresenter.dataLoaded(mockList);

        verify(mockView).updateList(mockList);
    }

    @Test
    public void shouldMakeNetworkCalltoGetDataFromNetwork() throws Exception {
        mainActivityPresenter.loadData();

        verify(mockNetworkManager).getData();
    }

    @Test
    public void shouldAbleCancelNetworkRequest() throws Exception {
        mainActivityPresenter.cancelRequest();

        verify(mockNetworkManager).cancelRequest();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalStateExceptionIfViewIsNull() throws Exception {
        //explicitly setting the view as null
        mainActivityPresenter.setView(null);

        List mockList = mock(List.class);
        mainActivityPresenter.setData(mockList);


    }
}