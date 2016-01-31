package com.gsmayya.cups.guava.collections;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.validation.constraints.NotNull;

/**
 * Created by gseethar on 5/2/15.
 */
public class WebSiteStats {

  private final String _url;

  private final List<SetCollector> _collectors = new ArrayList<>();
  private final List<MapCollector> _mapC = new ArrayList<>();

  private final BiMapTester<String, String> _biMap = new BiMapTester<>();

  public WebSiteStats(@NotNull String url) {
    _url = url;
    _collectors.add(new GoogleSetCollector());
    _mapC.add(new GoogleMapCollector());
    _mapC.add(new ApacheMapCollector());
  }


  public void process() throws IOException {

    new Scanner(new URL(_url).openStream(), "UTF-8").
        useDelimiter("\\s+|[,=\"<>.();{}:'\\-/?&|]").
        forEachRemaining(
            (token) -> {
              _collectors.forEach(
                  (c) -> c.collect(token)
              );
              _mapC.forEach(
                  (mc) -> mc.collect(token, 1)
              );
              Hasher hasher = Hashing.sha1().newHasher();
              hasher.putBytes(token.getBytes());
              _biMap.collect(token, hasher.hash().toString());
            }
        );

    _collectors.forEach(
        (c) -> System.out.println(c.toString())
    );
    System.out.println("Maps...");
    _mapC.forEach(
        (mc) -> System.out.println(mc.toString())
    );

    System.out.println(_biMap.toString());

  }

}
