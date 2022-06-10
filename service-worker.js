/**
 * Welcome to your Workbox-powered service worker!
 *
 * You'll need to register this file in your web app and you should
 * disable HTTP caching for this file too.
 * See https://goo.gl/nhQhGp
 *
 * The rest of the code is auto-generated. Please don't update this file
 * directly; instead, make changes to your Workbox build configuration
 * and re-run your build process.
 * See https://goo.gl/2aRDsh
 */

importScripts("https://storage.googleapis.com/workbox-cdn/releases/4.3.1/workbox-sw.js");

self.addEventListener('message', (event) => {
  if (event.data && event.data.type === 'SKIP_WAITING') {
    self.skipWaiting();
  }
});

/**
 * The workboxSW.precacheAndRoute() method efficiently caches and responds to
 * requests for URLs in the manifest.
 * See https://goo.gl/S9QRab
 */
self.__precacheManifest = [
  {
    "url": "404.html",
    "revision": "e51197bcfdda93d3d75e01aa9b33bde5"
  },
  {
    "url": "assets/css/0.styles.2b7609b0.css",
    "revision": "be38f6e1fb7779a310eef806b46ec562"
  },
  {
    "url": "assets/img/search.83621669.svg",
    "revision": "83621669651b9a3d4bf64d1a670ad856"
  },
  {
    "url": "assets/js/10.17dc7fc0.js",
    "revision": "235105471074525d1d2bdc9d1186bdf9"
  },
  {
    "url": "assets/js/11.32ba2003.js",
    "revision": "b012f550c9920cce59792eeb20924fd7"
  },
  {
    "url": "assets/js/12.f4d805b2.js",
    "revision": "45a0f424731485e8513dbf3f52453817"
  },
  {
    "url": "assets/js/13.b369ab95.js",
    "revision": "ff30346a2ae0704d1a7791e2ab06f152"
  },
  {
    "url": "assets/js/14.4fd45c58.js",
    "revision": "2826a1bfcbbdf9810af87b4f633a8390"
  },
  {
    "url": "assets/js/15.a48c8ad3.js",
    "revision": "2f057913696ff9becf5d0c816d821e82"
  },
  {
    "url": "assets/js/16.f868886d.js",
    "revision": "c675477f2e17bea2023b9fbafcbb22ee"
  },
  {
    "url": "assets/js/17.e54ffa32.js",
    "revision": "397aa16b2a25be54c84988d68d7b5b28"
  },
  {
    "url": "assets/js/18.393dbd29.js",
    "revision": "4dc9878951689875f62f246a270470a7"
  },
  {
    "url": "assets/js/19.7835ae59.js",
    "revision": "374df65b9b682f8b352e4cde19517798"
  },
  {
    "url": "assets/js/2.9df8b7a2.js",
    "revision": "613eef12571b272390e4d84a5a7700fd"
  },
  {
    "url": "assets/js/20.3fc6ed82.js",
    "revision": "e18dd04194a3019dac0d810f5c28165d"
  },
  {
    "url": "assets/js/21.c9227d2d.js",
    "revision": "6d729d140762ea4f7d38faa0e38b389a"
  },
  {
    "url": "assets/js/22.abbac38a.js",
    "revision": "2b77c6b20e9adda5824ed23e950a9687"
  },
  {
    "url": "assets/js/23.9c9cf32f.js",
    "revision": "ababb98b2fce59099380a5d4ca80a377"
  },
  {
    "url": "assets/js/24.ff833df3.js",
    "revision": "8e8ba06ffae2567d609037a4084f1f88"
  },
  {
    "url": "assets/js/26.2b7d224e.js",
    "revision": "d09140fd6d4af5d21412c1e04e0338bb"
  },
  {
    "url": "assets/js/3.33d6b42d.js",
    "revision": "808ea9f2d864b4467fe90f16175227a8"
  },
  {
    "url": "assets/js/4.5d00dd71.js",
    "revision": "354b2b53903cf28623245afa41ac130d"
  },
  {
    "url": "assets/js/5.4b8fb81c.js",
    "revision": "b865b25b78848b369ebb4f7a7684bf5b"
  },
  {
    "url": "assets/js/6.37f402c4.js",
    "revision": "43bdcf1e529c99fca1e216d96833b9ee"
  },
  {
    "url": "assets/js/7.a2994458.js",
    "revision": "817c1a9fc1e6f84583934d814a9ab3f5"
  },
  {
    "url": "assets/js/8.e8761b22.js",
    "revision": "df02b8b825d5757e125dbe170d1555c1"
  },
  {
    "url": "assets/js/9.c0a843c2.js",
    "revision": "6fdef7e064583d735d435c9c7be58314"
  },
  {
    "url": "assets/js/app.186b1b49.js",
    "revision": "00f4c14a783664cfb2ecacfbfa4fe6d1"
  },
  {
    "url": "conclusion/index.html",
    "revision": "7b16b906c511d13e36bfdcfc08aae3b0"
  },
  {
    "url": "design/index.html",
    "revision": "4c556d662ba8e52fa59d30b5b3a6fe0f"
  },
  {
    "url": "index.html",
    "revision": "154bc52f2518fd914f4220102b5f5a78"
  },
  {
    "url": "intro/index.html",
    "revision": "24c2d32d645fb415478864a15fc3fd94"
  },
  {
    "url": "license.html",
    "revision": "70a2edbdcd1a16b29dc6ec11e14ab937"
  },
  {
    "url": "myAvatar.png",
    "revision": "b76db1e62eb8e7fca02a487eb3eac10c"
  },
  {
    "url": "requirements/index.html",
    "revision": "628de8818c3fc384d8efc72088238fe2"
  },
  {
    "url": "requirements/stakeholders-needs.html",
    "revision": "e0a5607459cedc07a71fd9a7aef94f4c"
  },
  {
    "url": "requirements/state-of-the-art.html",
    "revision": "8224bd238d48c599484efe94bd98b9d9"
  },
  {
    "url": "software/index.html",
    "revision": "afc118fcb761760a3a77713aeaf5d16b"
  },
  {
    "url": "test/index.html",
    "revision": "9774711f3365dfea04ccd7fa6c836792"
  },
  {
    "url": "use cases/index.html",
    "revision": "0da8fcd6a775373ae4befc25e663bc36"
  }
].concat(self.__precacheManifest || []);
workbox.precaching.precacheAndRoute(self.__precacheManifest, {});
addEventListener('message', event => {
  const replyPort = event.ports[0]
  const message = event.data
  if (replyPort && message && message.type === 'skip-waiting') {
    event.waitUntil(
      self.skipWaiting().then(
        () => replyPort.postMessage({ error: null }),
        error => replyPort.postMessage({ error })
      )
    )
  }
})
